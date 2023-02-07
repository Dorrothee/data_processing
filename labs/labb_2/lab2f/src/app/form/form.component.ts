import { Component, OnInit, OnDestroy, Output, EventEmitter, Input } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Entity } from '../interfaces/entity';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
})
export class FormComponent implements OnInit, OnDestroy {
  public formGroup!: FormGroup;
  public model: Entity = {look: "assets/watch2.png", model: "Garmin Instinct 2 Solar Tactical", price: 610};
  @Output() public onChange: EventEmitter<FormGroup> = new EventEmitter<FormGroup>();
  @Output() public onInit: EventEmitter<FormGroup> = new EventEmitter<FormGroup>();
  @Output() public doPut: EventEmitter<Entity> = new EventEmitter<Entity>();

  constructor(private fb: FormBuilder) {

  }

  ngOnInit() {
    this.initForm();
    this.formGroup.valueChanges.subscribe(formData => {
        this.onChange.emit(this.formGroup);    
    });
    this.onInit.emit(this.formGroup);
  }

  private initForm() {
    this.formGroup = this.fb.group({
            look:[
                this.model.look, 
                [Validators.required,]        
            ],
            model:[
                this.model.model, 
                [Validators.required,]        
            ],
            price:[
                this.model.price, 
                [Validators.required,]        
            ],
    });
  }
  // convenience getter for easy access to form fields
   get f():any {
     return this.formGroup.controls;
   }

  addItem(formArrayName: string) {
    this.f[formArrayName].push(this.fb.control(''));
  }

  deleteItem(formArrayName: string, index: number) {
    this.f[formArrayName].removeAt(index);
  }

  ngOnDestroy() {

  }

  onSubmit(){
    if(this.formGroup.invalid == false){
      this.model.look=this.f['look'].value;
      this.model.model=this.f['model'].value;
      this.model.price=this.f['price'].value;
      this.doPut.emit(this.model);
    }
  }
}
