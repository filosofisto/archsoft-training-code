import {browser, by, element, ElementFinder} from 'protractor';

export class AppPage {
  navigateTo(): Promise<unknown> {
    return browser.get(browser.baseUrl) as Promise<unknown>;
  }

  getTitleText(): Promise<string> {
    return element(by.css('.page-header h1')).getText() as Promise<string>;
  }

  setSearch(value: string): Promise<void> {
    return element(by.css('input')).sendKeys(value) as Promise<void>;
  }

  clickSearchButton(): Promise<void> {
    return element(by.id('searchButton')).click() as Promise<void>;
  }

  elementById(id: string): ElementFinder {
    return element(by.id(id));
  }

}
