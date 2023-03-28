import { Component } from '@angular/core';
import { Watches } from './interfaces/entity';
import { Service1Service } from './services/service1.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'lab7f';

  entityList:Watches[]=[];

  constructor(private service:Service1Service){}
  Watch!: Watches[];

  getEntities():void{
    this.service.getEntities().subscribe(
      (entities)=>{
        this.Watch=entities._embedded.watches;
      }
    )
  }
}