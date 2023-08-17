import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import{HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentComponent } from './teacher/student.component';

import { PrimaryloginComponent } from './primarylogin/primarylogin.component';
import { StudviewComponent } from './studview/studview.component';
import { StudresultComponent } from './studresult/studresult.component';
import { ApiService } from './studresult/api.service';



@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
   
    PrimaryloginComponent,
    StudviewComponent,
    StudresultComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
    
  ],
  providers: [
    ApiService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
