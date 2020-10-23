cmake_minimum_required(VERSION 3.12)

project(stat)

set(CMAKE_POSITION_INDEPENDENT_CODE ON)
set(CMAKE_CXX_STANDARD 17)
set(JAVA /usr/lib64/jvm/jdk1.8.0_251)

include_directories(${JAVA}/include)
include_directories(${JAVA}/include/linux)

add_library(stat SHARED collector.cpp memory_usage.cpp memory_usage.h cpu_usage.h cpu_usage.cpp processes.cpp processes.h collector.cpp)