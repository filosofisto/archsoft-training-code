import { AppPage } from './app.po';
import { browser, logging } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getTitleText()).toContain('Spotify');
  });

  it('search by Metallica', () => {
    page.navigateTo();
    page.setSearch('Metallica');
    page.clickSearchButton();

    expect(page.elementById('artist_2ye2Wgw4gimLv2eAKyk1NB')).toBeTruthy();
    expect(page.elementById('track_5BIMPccDwShpXq784RJlJp')).toBeTruthy();
    expect(page.elementById('album_6QdCohkHKNTVoaSx1ZzitH')).toBeTruthy();
  });

  it('search by Iron Made', () => {
    page.navigateTo();
    page.setSearch('Iron Made');
    page.clickSearchButton();

    expect(page.elementById('artist_6FD0unjzGQhX3b6eMccMJe')).toBeTruthy();
    expect(page.elementById('track_63LVYnGJmWjNnmHiOVsGhe')).toBeTruthy();
    expect(page.elementById('album_2jCjUgaDh9lVGju6u3cGvK')).toBeTruthy();
  });

  it('search with empty result', () => {
    page.navigateTo();
    page.setSearch('!@#$%');
    page.clickSearchButton();

    expect(page.elementById('empty_result')).toBeTruthy();
  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
