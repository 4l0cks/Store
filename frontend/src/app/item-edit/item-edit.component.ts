import {Component, EventEmitter, Input, Output} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatButtonModule} from "@angular/material/button";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {HttpClient} from "@angular/common/http";
import {Item} from "../item";
import {MatDividerModule} from "@angular/material/divider";
import {MatIconModule} from "@angular/material/icon";
import {MatSelectModule} from "@angular/material/select";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatRadioModule} from "@angular/material/radio";

@Component({
  selector: 'app-item-edit',
  standalone: true,
    imports: [
        FormsModule,
        MatButtonModule,
        MatFormFieldModule,
        MatDividerModule,
        MatIconModule,
        MatCheckboxModule,
        FormsModule,
        MatInputModule,
        MatSelectModule,
        ReactiveFormsModule,
        MatRadioModule
    ],
  templateUrl: './item-edit.component.html',
  styleUrl: './item-edit.component.css'
})
export class ItemEditComponent {

  @Input() item: Item = new Item(0, "", "","",0,"");
  @Output() editDataEvent = new EventEmitter();

  constructor(private  http: HttpClient) {}

  onSubmit(): void {
    this.http.post<Item>(
      "http://localhost:8080/items",
      this.item
    ).subscribe(data => this.editDataEvent.emit(data))
  }
}
