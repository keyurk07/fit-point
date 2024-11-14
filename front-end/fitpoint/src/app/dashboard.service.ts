import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DashboardService {
  private baseUrl = 'http://localhost:9000/user/api';

  constructor(private http: HttpClient) {}

  // Updated method to fetch user by ID
  getUserById(id: number): Observable<any> {
    const url = `${this.baseUrl}/getById/${id}`;
    return this.http.get<any>(url);
  }
  display(): Observable<any> {
    const apiurl = 'http://localhost:9000/user/api/';
    return this.http.get<any>(apiurl);
  }


 
}
