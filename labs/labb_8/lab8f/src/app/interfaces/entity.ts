import { WatchesLinks } from "./rest.interfaces/wathes_links";

export interface Watches {
    id:number;
    look:string;
    model:string;
    price:number;
    _links?: WatchesLinks;
}