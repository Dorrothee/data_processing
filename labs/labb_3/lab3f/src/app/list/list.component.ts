import { Component, OnInit } from '@angular/core';
import { Entity } from '../interfaces/entity';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})

export class ListComponent implements OnInit {

  title:string="List of products";
  entitityList:Entity[]=[];
  showAddForm:boolean=false;
  selectedEntity?:Entity;

  constructor(private service:Service1Service) {}

  ngOnInit(): void{
    this.updateEntities();
    this.service.list.subscribe(
      (list:Entity[])=>{this.entitityList=list}
    );
  }

  updateEntities(){
    this.service.getEntities().subscribe(
      (entities)=>{
        this.service.setList(entities);
      }
    );
  }

  addEntities(entity:Entity){
    this.service.postEntities(entity).subscribe(
      (entities)=>{
        this.updateEntities();
      }
    );
    this.refreshPage();
  }

  onSelect(entity:Entity){
    if(this.selectedEntity && entity.id==this.selectedEntity.id){
      this.selectedEntity=undefined;
    } else{
      this.selectedEntity=entity;
    }
  }

  deleteEntities(entity:Entity){
    this.service.deleteEntities(entity).subscribe(
      ()=>{
        this.updateEntities();
      }
    );
    this.refreshPage();
  }

  refreshPage(): void{
    window.location.reload();
  }
}
