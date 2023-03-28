import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Watches } from '../interfaces/entity';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {

  list = new BehaviorSubject<Watches[]>([])

  url:string = "http://localhost:1313/lab6/api/watches";

  constructor(private http:HttpClient) { }

  getEntities():Observable<Watches[]>{
    return this.http.get<Watches[]>(this.url + "/get");
  }


  postEntities(entity:Watches):Observable<Watches[]>{
    return this.http.post<Watches[]>(this.url + "/toadd", entity);
  }


  putEntities(entity:Watches):Observable<Watches[]>{
    return this.http.put<Watches[]>(this.url + "/update" + `/${entity.id}`, entity);
  }


  deleteEntities(entity:Watches):Observable<Watches[]>{
    return this.http.delete<Watches[]>(this.url + "/delete" + `/${entity.id}`)
  }


  setList(list:Watches[]){
    this.list.next(list);
  }
}