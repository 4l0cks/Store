import {Component, EventEmitter, Input, Output} from '@angular/core';

import {ItemDisplayComponent} from "../item-display/item-display.component";
import {ItemEditComponent} from "../item-edit/item-edit.component";
import {Item} from "../item";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-item-wrapper',
  standalone: true,
  imports: [
    ItemDisplayComponent,
    ItemEditComponent,
    CommonModule
  ],
  templateUrl: './item-wrapper.component.html',
  styleUrl: './item-wrapper.component.css'
})
export class ItemWrapperComponent {
  @Input() item: Item = new Item(0, "", "","",0,"");
  @Output() removeItemEvent = new EventEmitter();

  editable: boolean = false;

  handleEditClick(): void {
    this.editable = true;
  }

  handleSaveEdition(item: Item): void {
    this.editable = false;
    this.item = item;
  }
}
