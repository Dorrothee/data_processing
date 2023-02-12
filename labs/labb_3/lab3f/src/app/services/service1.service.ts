import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Entity } from '../interfaces/entity';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {
url:string = "http://localhost:8888/lab3/interface";

  constructor(private http:HttpClient) { }

  getEntities():Observable<Entity[]>{
    return this.http.get<Entity[]>(this.url);
  }

  public putdata(Look: Object, Model: Object, Price: Object) {
    this.http.put(this.url + "?look="+Look+"&model="+Model+"&price="+Price, Price).subscribe(data => {
      console.log(data);
    });
  }
}