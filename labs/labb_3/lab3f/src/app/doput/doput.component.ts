import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-doput',
  templateUrl: './doput.component.html',
  styleUrls: ['./doput.component.scss']
})
export class DoputComponent {

  constructor(private service: Service1Service) { }

  look: string = '';
  model: string = '';
  price: number = 0;

  getlook(val: string) {
    console.warn(val)
    this.look = val
  }
  getmodel(val: string) {
    console.warn(val)
    this.model = val
  }
  getprice(p: NgForm) {
    this.price = parseInt(p.value.price)
  }

  OnClick(): void {
    console.log(this.look)
    console.log(this.model)
    console.log(this.price)
    this.service.putdata(this.look, this.model, this.price);
  }

}