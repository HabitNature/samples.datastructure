package org.samples.datastructure;

import lombok.Data;

@Data
public class SinglePointerNode<E> {
    private E data;
    private SinglePointerNode<E> next;
}
