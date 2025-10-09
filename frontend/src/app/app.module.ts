import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';  
import { StudentSampleComponent } from './educonnect/components/studentsample/studentsample.component';
import { TeacherSampleComponent } from './educonnect/components/teachersample/teachersample.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    StudentSampleComponent,
    TeacherSampleComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
