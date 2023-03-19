import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Watches } from '../interfaces/entity';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {
  @Input() entity?:Watches
  @Output() updated:EventEmitter<null> = new EventEmitter();
  constructor(private service:Service1Service) {}

  ngOnInit(): void {
    
  }

  updateEntities(){
    if(this.entity){
      this.service.putEntities(this.entity).subscribe(
        ()=>{this.updated.emit();}
      );
    }
    this.refreshPage();
  }

  refreshPage(): void{
    window.location.reload();
  }
}
