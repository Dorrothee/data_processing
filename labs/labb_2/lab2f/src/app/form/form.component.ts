import { Component, OnInit, OnDestroy, Output, EventEmitter, Input } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'form',
  templateUrl: 'form.component.html',
  styleUrls: ['form.component.scss'],
})
export class FormComponent implements OnInit, OnDestroy {
  public formGroup!: FormGroup;
  @Input() public model: any = {}; // type this properly
  @Output() public onChange: EventEmitter<FormGroup> = new EventEmitter<FormGroup>();
  @Output() public onInit: EventEmitter<FormGroup> = new EventEmitter<FormGroup>();

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
}
