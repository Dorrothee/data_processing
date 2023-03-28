import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Watches } from '../interfaces/entity';
import { Http } from '../interfaces/rest.interfaces/http';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {

  list = new BehaviorSubject<Watches[]>([])

  url:string = "http://localhost:8080/watches";

  constructor(private http:HttpClient) { }

  getEntities():Observable<Http>{
    return this.http.get<Http>(this.url);
  }


  postEntities(entity:Watches):Observable<Watches[]>{
    return this.http.post<Watches[]>(this.url, entity);
  }


  putEntities(entity:Watches):Observable<Watches[]>{
    return this.http.put<Watches[]>(this.url + `/${entity.id}`, entity);
  }


  deleteEntities(entity:Watches):Observable<Watches[]>{
    return this.http.delete<Watches[]>(this.url + `/${entity.id}`)
  }


  setList(list:Watches[]){
    this.list.next(list);
  }
}