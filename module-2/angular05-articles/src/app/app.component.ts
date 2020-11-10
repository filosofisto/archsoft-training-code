import { Component } from '@angular/core';
import { Article } from './model/article';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'angular05-articles';
  articles: Article[] = [];

  constructor() {

  }

  addArticle(newtitle: HTMLInputElement, newlink: HTMLInputElement): boolean {
    console.log(`${newtitle.value} - ${newlink.value}`);
    this.articles.push(new Article(newtitle.value, newlink.value, 0))
    return false;
  }

  sortedArticles(): Article[] {
    return this.articles.sort((a: Article, b: Article) => b.votes - a.votes);
  }
}
