import { Component } from '@angular/core';
import { Entity } from '../interfaces/entity';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent {
  title = 'lab1f';

  entityList:Entity[]=[];

  constructor(private service:Service1Service){}

  getEntities():void{
    this.service.getEntities().subscribe(
      (entities)=>{
        this.entityList=entities;
      }
    )
  }
}
