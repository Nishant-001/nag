import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import{map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private _http:HttpClient) { }
  //create by post

  poststudent(data:any){
    return this._http.post<any>("http://localhost:3000/studData",data)
    .pipe(map((res:any)=>{
      return res;
    }))
  }

  //get
  getstudent(){
    return this._http.get<any>("http://localhost:3000/studData")
    .pipe(map((res:any)=>{
      return res;

     }))

    }

    //update

    updatestudent(data:any,id:number){
      return this._http.put("http://localhost:3000/studData/"+id,data)
      .pipe(map((res:any)=>{
        return res;
  
      }))
    }

    //delete
    deletestudent(id:number){
      return this._http.delete<any>("http://localhost:3000/studData/"+id)
      .pipe(map((res:any)=>{
        return res;
  
      }))
    }
  
}
