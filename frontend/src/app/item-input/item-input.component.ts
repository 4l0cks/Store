import {Component, EventEmitter, Output, ViewChild} from '@angular/core';
import {FormsModule, NgForm} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Item} from "../item";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import {MatButtonModule} from "@angular/material/button";
import {MatCardModule} from "@angular/material/card";
import {MatRadioModule} from "@angular/material/radio";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatIconModule} from "@angular/material/icon";
import {MatDividerModule} from "@angular/material/divider";

@Component({
  selector: 'app-item-input',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatDividerModule,
    MatIconModule,
    FormsModule,
    MatCardModule,
    MatCheckboxModule,
    MatRadioModule
  ],
  templateUrl: './item-input.component.html',
  styleUrl: './item-input.component.css'
})
export class ItemInputComponent {

  @ViewChild("itemForm") itemForm!: NgForm;

  @Output() newDataEvent = new EventEmitter();

  constructor(private  http: HttpClient) {}

  onSubmit(): void {
    this.http.post<Item>(
      "http://localhost:8080/items",
      this.itemForm.value
    ).subscribe(data => this.newDataEvent.emit(data))
  }
}
