import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import {Course} from '../model/course';
import {CoursesService} from '../services/courses.service';
import {debounceTime, distinctUntilChanged, startWith, tap, delay} from 'rxjs/operators';
import {merge, fromEvent} from 'rxjs';
import {Lesson} from '../model/lesson';
import {Meta, Title} from '@angular/platform-browser';


@Component({
    selector: 'course',
    templateUrl: './course.component.html',
    styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

    course:Course;

    dataSource: MatTableDataSource<Lesson>;

    displayedColumns= ["seqNo", "description", "duration"];


    constructor(
        private route: ActivatedRoute,
        private coursesService: CoursesService,
        private title: Title,
        private meta: Meta) {}

    ngOnInit() {

        this.course = this.route.snapshot.data["course"];

        this.title.setTitle(this.course.description);

        this.meta.updateTag({name: "description", content: this.course.longDescription});

        this.meta.addTag({name: 'twitter:card', content: 'summary'});
        this.meta.addTag({name: 'twitter:site', content: '@AngularUniv'});
        this.meta.addTag({name: 'twitter:title', content: this.course.description});
        this.meta.addTag({name: 'twitter:description', content: this.course.description});
        this.meta.addTag({name: 'twitter:text:description', content: this.course.description});
        this.meta.addTag({name: 'twitter:image', content: 'https://avatars3.githubusercontent.com/u/16628445?v=3&s=200'});


        this.dataSource = new MatTableDataSource([]);

        this.coursesService.findAllCourseLessons(this.course.id)
            .subscribe(lessons => this.dataSource.data = lessons);

    }


}
