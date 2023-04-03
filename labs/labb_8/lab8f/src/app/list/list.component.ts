import { Component, OnInit } from '@angular/core';
import { Watches } from '../interfaces/entity';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})

export class ListComponent implements OnInit {

  title:string="List of products";
  entitityList:Watches[]=[];
  showAddForm:boolean=false;
  selectedEntity?:Watches;

  constructor(private service:Service1Service) {}

  ngOnInit(): void{
    this.updateEntities();
    this.service.list.subscribe(
      (list:Watches[])=>{this.entitityList=list}
    );
  }

  updateEntities(){
    this.service.getEntities().subscribe(
      (entities)=>{
        this.entitityList=entities;
      }
    )
  }

  addEntities(entity:Watches){
    this.service.postEntities(entity).subscribe(
      (entities)=>{
        this.updateEntities();
      }
    );
  }

  onSelect(entity:Watches){
    if(this.selectedEntity && entity.id==this.selectedEntity.id){
      this.selectedEntity=undefined;
    } else{
      this.selectedEntity=entity;
    }
  }

  deleteEntities(entity:Watches){
    this.service.deleteEntities(entity).subscribe(
      ()=>{
        this.updateEntities();
      }
    );
  }

}
