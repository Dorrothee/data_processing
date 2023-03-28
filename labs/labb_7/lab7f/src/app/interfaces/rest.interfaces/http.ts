import { Watches } from "../entity";
import { Page } from "./page";
import { RootLinks } from "./root_links";

export interface Http {
    _embedded: {
      watches: Watches[];
    };
    _links: RootLinks;
    page: Page;
  }