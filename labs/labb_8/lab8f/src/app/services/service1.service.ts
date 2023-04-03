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

  url:string = "http://localhost:8080/api/watches";
  mainurl:string = "http://localhost:8080/watches";

  constructor(private http:HttpClient) { }

  showEntities():Observable<Http>{
    return this.http.get<Http>(this.mainurl);
  }

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