import { Component } from '@angular/core';
import { Watches } from '../interfaces/entity';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent {
  title = 'lab4f';

  entityList:Watches[]=[];

  constructor(private service:Service1Service){}

  ngOnInit():void{
    this.service.getEntities().subscribe(
      (entities)=>{
        this.entityList=entities;
      }
    )
  }
}
