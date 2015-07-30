# Main target: Move Android icons from Android Asset Studio
# to be grouped in a single folder.
#
# Usage: Move this script to the folder where you want to bubble up some
# subdirectories (copies by default). Then run with Python 2: `python bubble_up_subdirectories.py`
#
# Before:
#     ./
#         a/
#             res/
#                 drawable-mdpi/ic_name_a.png
#                 drawable-hdpi/ic_name_a.png
#                 drawable-xhdpi-v21/ic_name_a.png
#         b/
#             res/
#                 drawable-mdpi/ic_name_b.png
#                 drawable-hdpi/ic_name_b.png
#                 drawable-xhdpi-v21/ic_name_b.png
#         c/
#             res/
#                 drawable-mdpi/ic_name_c.png
#                 drawable-hdpi/ic_name_c.png
#                 drawable-xhdpi-v21/ic_name_c.png
#
# After:
#     ./
#         res/
#             drawable-mdpi/
#                 ic_name_a.png
#                 ic_name_b.png
#                 ic_name_c.png
#             drawable-hdpi/
#                 ic_name_a.png
#                 ic_name_b.png
#                 ic_name_c.png
#             drawable-xhdpi-v21/
#                 ic_name_a.png
#                 ic_name_b.png
#                 ic_name_c.png
#
#
# Note: Things can get overwritten if they have the same name in the same subdirectories.
# 
# TODO: Maybe allow command line options: https://docs.python.org/2/library/argparse.html#module-argparse
#
# For more information, contact Danial Goodwin.
# Last updated: 2015-07-28

import os
import shutil

DIRECTORY_FROM = '.'
IS_SHOW_DEBUG_LOG = True


# More info: https://docs.python.org/2/library/os.html#os.walk
# More info: https://docs.python.org/2/library/shutil.html
# More info: https://docs.python.org/2/library/string.html#string.rfind
def bubble_up_subdirectories(top, is_copy=True, depth=0):
    if IS_SHOW_DEBUG_LOG:
        print "bubble_up_subdirectories(top=" + top + ")"
    for root, dirs, files in os.walk(top):
        for name in dirs:
            bubble_up_subdirectories(os.path.join(root, name), is_copy, depth + 1)
        for name in files:
            if (depth != 0):
                src = os.path.join(root, name)
                if IS_SHOW_DEBUG_LOG:
                    print 'src=' + src
                dst = src[src.index(os.path.sep) + 1:]
                dst = dst[dst.index(os.path.sep) + 1:dst.rindex(os.path.sep)]
                if IS_SHOW_DEBUG_LOG:
                    print 'dst=' + dst
                if not os.path.exists(dst):
                    os.makedirs(dst)
                if is_copy:
                    shutil.copy(src, dst)
                else:
                    shutil.move(src, dst)


bubble_up_subdirectories(DIRECTORY_FROM)
