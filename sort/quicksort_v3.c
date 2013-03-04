#include <stdio.h>

void swap(int *a, int *b){
	int tmp = *a;
	*a = *b;
	*b = tmp;
}


int partition(int A[], int si, int ei){
	int x = A[ei];
	int i = si-1;
	int j;
	for(j =si; j< ei; j++){
		if(A[j] <= x){
			i++;
			swap(&A[i], &A[j]);
		}
	}
	swap(&A[i+1], &A[ei]);
	return i+1;
}

void quicksort(int A[], int si, int ei){
	if(si < ei){
		int p = partition(A, si, ei);
		quicksort(A, si, p-1);
		quicksort(A, p+1, ei);
	}
}

int main(){

	int a[] = {6 ,5, 4, 3, 2 ,1};
	quicksort(a, 0, 5);
	int i = 0;

	for( i = 0; i < 6; i++){
		printf("%d", a[i]);
	}
}