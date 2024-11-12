import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { ErrorComponent } from './error/error.component';
import { SignupComponent } from './signup/signup.component';
import { ExerciseComponent } from './exercise/exercise.component';
import { CardioComponent } from './cardio/cardio.component';
import { WeightComponent } from './weight/weight.component';
import { DietComponent } from './diet/diet.component';


const routes: Routes = [
  { path: '', component: HomepageComponent }, 
  { path: 'login', component: LoginComponent },
  { path: 'homepage', component: HomepageComponent },
  {path: 'signup',component:SignupComponent},
  {path:'exercise',component:ExerciseComponent},
  {path:'food',component:DietComponent},
  {path:'cardio',component: CardioComponent},  
  {path:'weight',component:WeightComponent}, 
  { path: '**', component: ErrorComponent } 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }