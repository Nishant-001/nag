import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { ApiService } from '../shared/api.service';
import { studentdata } from './student.model';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
showadd!:boolean;
showupdate!:boolean;
studentmodelobj:studentdata=new studentdata;
formValue!:FormGroup
allstudentdata:any;
  constructor(private formBuilder:FormBuilder,private api:ApiService) { }

  ngOnInit(): void {
    this.formValue=this.formBuilder.group({
      rollno:['',Validators.required],
      name:['',Validators.required],
      dateofbirth:['',Validators.required],
      score:['',Validators.required],
    })
    this.getdata()


  }
  add(){
    this.showadd=true;
    this.showupdate=false;
  }
  edit(data:any){
    this.showadd=false;
    this.showupdate=true;
    this.studentmodelobj.id=data.id
    this.formValue.controls['rollno'].setValue(data.rollno)
    this.formValue.controls['name'].setValue(data.name)
    this.formValue.controls['dateofbirth'].setValue(data.dateofbirth)
    this.formValue.controls['score'].setValue(data.score)
  }

  //update on edit

  update(){
    this.studentmodelobj.rollno=this.formValue.value.rollno;
    this.studentmodelobj.name=this.formValue.value.name;
    this.studentmodelobj.dateofbirth=this.formValue.value.dateofbirth;
    this.studentmodelobj.score=this.formValue.value.score;

    this.api.updatestudent(this.studentmodelobj,this.studentmodelobj.id).subscribe(res=>{
      this.formValue.reset();
      this.getdata();
      alert("Record Updated Successfully");

    },
    err=>{
      alert("Something went wrong");
    })

  }

  addstudent(){
    this.studentmodelobj.rollno=this.formValue.value.rollno;
    this.studentmodelobj.name=this.formValue.value.name;
    this.studentmodelobj.dateofbirth=this.formValue.value.dateofbirth;
    this.studentmodelobj.score=this.formValue.value.score;

    this.api.poststudent(this.studentmodelobj).subscribe(res=>{
      console.log(res)
      this.formValue.reset()
    this.getdata()
      alert("Record Added Successfully");
    },
    err=>{
    alert("Something went wrong!");
    })

  }


  //getdata()

  getdata(){
    this.api.getstudent()
    .subscribe(res=>{
      this.allstudentdata=res;
    })
  }

  //delete

  deletestudent(data:any){
    if(confirm('Are you sure to delete?'))
    this.api.deletestudent(data.id)
    .subscribe(res=>{
    alert("Record Deleted Successfully")  
    this.getdata();
    })
  }



}
