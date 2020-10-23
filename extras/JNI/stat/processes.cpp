#include <stdio.h>
#include <stdlib.h>
#include "processes.h"

/**
 * Returns quantity of processes executing
 */
int processes()
{
    int ret = -1;
    FILE *fp = popen("ps aux | wc -l", "r");

    if (fp != nullptr) {
        char output[1024];

        fgets(output, sizeof(output)-1, fp);
        ret = atoi(output);
    }

    pclose(fp);

    return ret;
}