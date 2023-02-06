import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormComponent } from './form.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from "@angular/material/button";

@NgModule({
  imports: [
    CommonModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatSelectModule,
    MatRadioModule,
    MatInputModule,
    MatButtonModule
  ],
    providers: [],
    declarations: [
        FormComponent,
    ],
    exports: [
       FormComponent,
    ]
})
export class FormModule {

}
