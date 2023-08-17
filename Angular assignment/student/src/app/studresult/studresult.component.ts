import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from './api.service';

@Component({
  selector: 'app-studresult',
  templateUrl: './studresult.component.html',
  styleUrls: ['./studresult.component.css']
})
export class StudresultComponent implements OnInit {
  // studentdata !: any;
  
  user:any
  user1:any
  studentdata:any
  

  constructor(private router:Router,private api:ApiService,private http:HttpClient) {
    // console.log(this.getData())
    this.getData();
    
   }
   getData(){
    let data:any=localStorage.getItem('rollno')
    this.user=JSON.parse(data);
    let data1:any=localStorage.getItem('name')
    this.user1=JSON.parse(data1);
    this.http.get<any>("http://localhost:3000/studData/?rollno="+this.user+"&name="+this.user1).subscribe(res=>{
      console.log(res)
      this.studentdata=res
     
    })
    // alert(data)
   }

  ngOnInit(): void {
  }

}
