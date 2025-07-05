#include <bits/stdc++.h>
using namespace std;

int main() {
    string hay = "i am groot";
    string target = "am";
    int start = -1;
    bool found = false;

    for (int i = 0; i <= hay.length() - target.length(); i++) {
        if (hay[i] == target[0]) {
            int k = 1;
            bool match = true;

            for (int j = i + 1; j < i + target.length(); j++) {
                if (hay[j] != target[k]) {
                    match = false;
                    break;
                }
                k++;
            }

            if (match) {
                start = i;
                found = true;
                break; 
                
            }
        }
    }

    if (found) {
        cout << "Matched at index: " << start << endl;
    } else {
        cout << "No matches found." << endl;
    }

    return 0;
}
