import { Component } from '@angular/core';

import { OnInit } from '@angular/core';
import { GoogleGenerativeAI } from '@google/generative-ai';



@Component({
  selector: 'app-recommendations',
  templateUrl: './recommendations.component.html',
  styleUrls: ['./recommendations.component.css']
})
export class RecommendationsComponent implements OnInit {

  userInput: string = '';
  messages: { text: string; from: 'user' | 'bot' }[] = [];

  genAi = new GoogleGenerativeAI("AIzaSyBLBAFjTp548gsXGRhbvvAuBL0qRM3aiFE");
  model = this.genAi.getGenerativeModel({ model: "gemini-1.5-flash" });

  ngOnInit(): void {
    this.messages.push({ text: 'Hello! How can I help you today?', from: 'bot' });
  }

  async sendMessage() {
    if (this.userInput.trim() === '') return;

    this.messages.push({ text: this.userInput, from: 'user' });
    
    const result = await this.TestGemini(this.userInput);
    const formattedResponse = this.formatResponse(result.response.text());
    this.messages.push({ text: formattedResponse, from: 'bot' });

    this.userInput = '';
  }

  async TestGemini(prompt: string) {
    return await this.model.generateContent(prompt);
  }

  formatResponse(response: string): string {
    // Replace '**text**' with '<strong>text</strong>' and similar transformations
    return response.replace(/\*\*(.*?)\*\*/g, '<strong>$1</strong>');
  }
}
