import { Component } from "@angular/core";
import { Teacher } from "../../models/Teacher";


@Component({
    selector: 'teacher-root',
    templateUrl: './teachersample.component.html',
    styleUrls: ['./teachersample.component.scss'],
    standalone:true
  })
export class TeacherSampleComponent  {

    teacher:Teacher;
    constructor()
    {
     this.teacher=new Teacher(1,"a","math","99939399","abc@gmail.com",89,);
    }
    logTeacherAttributes()
  {
    console.log("student:",this.teacher);
  }

  
}
