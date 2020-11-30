import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditDocumentationComponent } from './edit-documentation.component';

describe('EditDocumentaitonComponent', () => {
  let component: EditDocumentationComponent;
  let fixture: ComponentFixture<EditDocumentationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditDocumentationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditDocumentationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
