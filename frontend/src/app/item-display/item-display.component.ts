import {Component, EventEmitter, Input, Output} from '@angular/core';
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {Item} from "../item";

@Component({
  selector: 'app-item-display',
  standalone: true,
  imports: [
    MatCardModule, MatButtonModule
  ],
  templateUrl: './item-display.component.html',
  styleUrl: './item-display.component.css'
})
export class ItemDisplayComponent {

  @Input() item: Item = new Item(0, "", "","",0,"");

  @Output() removeItemEvent = new EventEmitter();
  @Output() editItemEvent = new EventEmitter();
}
