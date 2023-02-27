import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Watches } from '../interfaces/entity';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {

  list = new BehaviorSubject<Watches[]>([])

  url:string = "http://localhost:8888/lab4/interface";

  constructor(private http:HttpClient) { }

  getEntities():Observable<Watches[]>{
    return this.http.get<Watches[]>(this.url);
  }


  postEntities(entity:Watches):Observable<Watches[]>{
    return this.http.post<Watches[]>(this.url,entity);
  }


  putEntities(entity:Watches):Observable<Watches[]>{
    return this.http.put<Watches[]>(this.url+"/"+entity.id,entity);
  }


  // public putdata(Look: Object, Model: Object, Price: Object) {
  //   this.http.put(this.url + "?look="+Look+"&model="+Model+"&price="+Price, Price).subscribe(data => {
  //     console.log(data);
  //   });
  // }


  deleteEntities(entity:Watches):Observable<Watches[]>{
    return this.http.delete<Watches[]>(this.url+"/"+entity.id)
  }


  setList(list:Watches[]){
    this.list.next(list);
  }
}