package org.backend.backend.exception

class ResourceNotFoundException : RuntimeException {
    constructor(message: String) : super(message)
}