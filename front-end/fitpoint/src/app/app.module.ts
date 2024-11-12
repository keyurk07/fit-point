import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';
import { FormsModule } from '@angular/forms';

import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ErrorComponent } from './error/error.component';
import { ExerciseComponent } from './exercise/exercise.component';
import { CardioComponent } from './cardio/cardio.component';
import { WeightComponent } from './weight/weight.component';
import { DietComponent } from './diet/diet.component';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,

    SignupComponent,
     LoginComponent,
     NavbarComponent,
     ErrorComponent,
     ExerciseComponent,
     CardioComponent,
     WeightComponent,
     DietComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }