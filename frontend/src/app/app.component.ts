import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Item} from "./item";
import {HttpClient} from "@angular/common/http";
import {ItemDisplayComponent} from "./item-display/item-display.component";
import {ItemInputComponent} from "./item-input/item-input.component";
import {NgFor} from "@angular/common";
import {ItemWrapperComponent} from "./item-wrapper/item-wrapper.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ItemDisplayComponent, ItemInputComponent, NgFor, ItemWrapperComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  items: Item[] = [];

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.http.get<Item[]>(
      "http://localhost:8080/items"
    ).subscribe(data => this.items = data)
  }

  appendData(newItem: any) {
    this.items.push(newItem);
  }

  removeItem(itemId: number): void {
    this.http.delete(
    "http://localhost:8080/items/" + itemId,
    ).subscribe(data => this.items = this.items.filter((item: Item) => item.id != itemId));
  }
}
