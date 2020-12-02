export class PagerData {

  constructor(public data: any) { }

  lastPage(): number {
    return this.data['page']['totalPages'] - 1;
  }

  hasNext(): boolean {
    return this.currentPage() < this.lastPage();
  }

  nextPage(): number {
    return this.currentPage() + 1;
  }

  currentPage(): number {
    return this.data['page']['number'];
  }

  hasBefore(): boolean {
    return this.currentPage() > 0;
  }

  isFirst(): boolean {
    return this.currentPage() === 0;
  }

  totalElements(): number {
    return this.data['page']['totalElements'];
  }

  totalPages(): number {
    return this.data['page']['totalPages'];
  }

  hasItems(): boolean {
    return this.totalElements() > 0;
  }

  // static default(context: string): PagerData<any> {
  //   return new PagerData(
  //     context,
  //     [],
  //     new Pageable(new Sort(false, true, true), 0, 0, 0, true, false),
  //     0, 0, false, 0, new Sort(false, true, true), 0, false, true
  //   );
  // }
  isCurrent(page: number): boolean {
    return this.currentPage() === page;
  }

  isLast(): boolean {
    return this.currentPage() === this.lastPage();
  }
}
