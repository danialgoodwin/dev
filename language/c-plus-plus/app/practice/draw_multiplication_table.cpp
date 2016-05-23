// Description: Draw a minimal table.

#include <iostream>
using namespace std;

int main() {
  cout << "   1\t2\t3\t4\t5\t6\t7\t8\t9" << endl << "" << endl;
  for (int c = 1; c <= 9; c++) {
    cout << c << "| ";
    for (int i = 1; i <= 9; i++) {
      cout << i * c << '\t';
    }
    cout << endl;
  }
  return 0;
}
