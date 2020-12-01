import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentationReadComponent } from './documentation-read.component';

describe('DocumentationComponent', () => {
  let component: DocumentationReadComponent;
  let fixture: ComponentFixture<DocumentationReadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocumentationReadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentationReadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
