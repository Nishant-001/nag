import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PrimaryloginComponent } from './primarylogin/primarylogin.component';
import { StudentComponent } from './teacher/student.component';
import { StudviewComponent } from './studview/studview.component';
import { StudresultComponent } from './studresult/studresult.component';



const routes: Routes = [
  {path:'teacher',component:StudentComponent},
  {path:'studview',component:StudviewComponent},
  {path:'primarylogin',component:PrimaryloginComponent},
  {path:'studresult',component:StudresultComponent},
  {path:'**',component:PrimaryloginComponent},
  {path:'',redirectTo:'primarylogin',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
