import {HeroService} from '../hero.service';
import {HeroListComponent} from './hero-list.component';

const expectedHeroes = [{name: 'A'}, {name: 'B'}];
const mockService = <HeroService> { getHeroes: () => expectedHeroes };

it('should heve heroes when HeroListComponent created', () => {
  const component = new HeroListComponent(mockService);
  expect(component.heroes.length).toEqual(expectedHeroes.length);
});
// import { ComponentFixture, TestBed } from '@angular/core/testing';
//
// import { HeroListComponent } from './hero-list.component';
//
// describe('HeroListComponent', () => {
//   let component: HeroListComponent;
//   let fixture: ComponentFixture<HeroListComponent>;
//
//   beforeEach(async () => {
//     await TestBed.configureTestingModule({
//       declarations: [ HeroListComponent ]
//     })
//     .compileComponents();
//   });
//
//   beforeEach(() => {
//     fixture = TestBed.createComponent(HeroListComponent);
//     component = fixture.componentInstance;
//     fixture.detectChanges();
//   });
//
//   it('should create', () => {
//     expect(component).toBeTruthy();
//   });
// });
