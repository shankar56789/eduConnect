import { Component,NgModule } from "@angular/core";
import { Teacher } from "../../models/Teacher";
import { CommonModule } from "@angular/common";
import { NgModel } from "@angular/forms";

@NgModule({
    declarations:[TeacherArrayComponent],
    imports:[CommonModule],
})

@Component({
    selector:'teacher-root',
    templateUrl:'./teacherarray.component.html',
    styleUrls:['./teacherarray.component.scss']
})
export class TeacherArrayComponent  {
    teachers: Teacher[]
    =[
        new Teacher(1,"abc","9876544210","abc@gmail.com","Maths",5),
        new Teacher(2,"def","9876544211","def@gmail.com","Science",2),
        new Teacher(3,"ghi","9876544212","ghi@gmail.com","English",9)
    ];
    showDetails:boolean=false;
    constructor(){
    }
    toggleDetails():void{
        this.showDetails=!this.showDetails;
    }

}
