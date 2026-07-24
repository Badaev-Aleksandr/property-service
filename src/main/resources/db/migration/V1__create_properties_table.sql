CREATE TABLE properties
(
    id UUID NOT NULL DEFAULT gen_random_uuid(),
    title VARCHAR(200) NOT NULL,
    description TEXT,
    price NUMERIC(12, 2) NOT NULL,
    city VARCHAR(100) NOT NULL ,
    address VARCHAR(200) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT pk_properties PRIMARY KEY (id),
    CONSTRAINT chk_properties_price_positive CHECK (price > 0)
)