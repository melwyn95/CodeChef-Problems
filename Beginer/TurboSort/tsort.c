#include <stdio.h>

void display(int* a, int start, int end);
int partition(int* a, int start, int end);
void quick_sort(int* a, int start, int end);
void swap(int* a, int* b);

int main() {
    int n, i;
    scanf("%d",&n);
    int a[n];
    for (i=0;i<n;i++)  scanf("%d",&a[i]);
	quick_sort(a, 0, n-1);
    display(a, 0, n - 1);
    return 0;
}

void display(int* a, int start, int end) {
    for (;start<=end;start++) printf("%d\n",a[start]);
}

void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

int partition(int* a, int start, int end) {
    int pivot = a[start];
    int low = start+1;
    int high = end;
    while (low <= high) {
        while (a[low] < pivot && low <= end) low++;
        while (a[high] > pivot && high >= start) high--;
        if (low < high) swap(&a[low], &a[high]);
    }
    a[start] = a[high];
    a[high] = pivot;
    return high;
}

void quick_sort(int* a, int start, int end) {
    if (start < end) {
        int pivot_index = partition(a, start, end);
        quick_sort(a, start, pivot_index - 1);
        quick_sort(a, pivot_index + 1, end);
    }
}
