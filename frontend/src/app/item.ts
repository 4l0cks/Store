export class Item {
  constructor(
    public id : number | null,
    public brand: string,
    public name: string,
    public description : string,
    public price : number,
    public type : string
  ) {
  }
}
