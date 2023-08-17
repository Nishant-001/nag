import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiService } from '../studresult/api.service';

@Component({
  selector: 'app-studview',
  templateUrl: './studview.component.html',
  styleUrls: ['./studview.component.css']
})
export class StudviewComponent implements OnInit {
  formValue !: FormGroup;
  user: any={};

  constructor(private formBuilder:FormBuilder,private router:Router,private http:HttpClient,private apiService:ApiService) { }

  ngOnInit(): void {
    this.formValue=this.formBuilder.group({
      rollNo:['',Validators.required],
      name:['',Validators.required]
    })
  }

  search(){
    // console.log(this.formValue.value.name )
    this.http.get<any>("http://localhost:3000/studData/?rollno="+ this.formValue.value.rollNo+"&name="+this.formValue.value.name).subscribe(res=>{
      //match email and password
      // console.log(res)
     
      if(res[0]){
        alert("Successfully logged in");
        this.formValue.reset();
        this.router.navigate(['studresult'])
        this.user=res[0]
        localStorage.setItem('rollno',JSON.stringify(this.user.rollno))
        localStorage.setItem('name',JSON.stringify(this.user.name))
        
      }else{
        alert("User not found");
      } 
       
    })
  }
  clear(){
    this.formValue.controls['rollNo'].setValue("");
    this.formValue.controls['name'].setValue("")

  }

 

}
